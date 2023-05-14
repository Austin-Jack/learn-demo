package cn.llynsyw.java.basic.summary.demo09;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;


public class FileUpload_Client {
    public static void main(String[] args) {
        new ClientWindow().setVisible(true);
    }
}


class ClientWindow extends JFrame {
    public ClientWindow() {
        //设置可见
        setVisible(true);
        //设置默认退出方式
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JList uploadArea = new JList();
        uploadArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

        JScrollPane scrollPane = new JScrollPane(uploadArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JPanel operateArea = new JPanel(new FlowLayout());

        DefaultListModel<File> model = new DefaultListModel<File>();

        JButton upload = new JButton("上传");
        JButton cancel = new JButton("取消");
        JButton exit = new JButton("退出");
        //取消按钮焦点框
        upload.setFocusPainted(false);
        upload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                while (i < model.getSize()) {
                    Upload_Server.listFile(model.getElementAt(i));
                    i++;
                }
            }
        });

        cancel.setFocusPainted(false);
        exit.setFocusPainted(false);
        uploadArea.setModel(model);
        DropTargetListener dropListener = new DropTargetAdapter() {
            @Override
            public void drop(DropTargetDropEvent dtde) {
                boolean isAccept = false;
                try {
                    //如果是文件或者文件夹
                    if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                        dtde.acceptDrop(DnDConstants.ACTION_MOVE);
                        isAccept = true;
                        //支持同时拖拽多个，一个文件占用一个元素
                        List<File> files = (List<File>) dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);

                        for (File file : files) {
                            model.add(0, file);
                        }

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (isAccept) {
                    dtde.dropComplete(true);
                } else {
                    dtde.rejectDrop();
                }
            }
        };

        new DropTarget(uploadArea, DnDConstants.ACTION_NONE, dropListener, true);
        operateArea.add(upload);
        operateArea.add(cancel);
        operateArea.add(exit);
        add(operateArea, BorderLayout.SOUTH);
        add(uploadArea);

        setTitle("文件上传工具");
        setLocationRelativeTo(null);
        setSize(400, 300);
        setAlwaysOnTop(true);
    }

}

class Upload_Server {


    public static void upload(String filepath) {
        try {
            //建立读取文本输入流
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filepath));

            Socket socket = new Socket("47.106.221.6", 6666);
            //创建输出流 写到服务器
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

            byte[] b = new byte[1024 * 8];
            int len;
            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);
            }

            socket.shutdownOutput();
            socket.close();
            bis.close();
            bos.close();
            System.out.println(System.currentTimeMillis() + "上传了" + filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void listFile(File file) {
        File[] files = file.listFiles(pathname -> pathname.isDirectory());
        for (File f : files) {
            if (f.isFile()) {
                String path = f.getAbsolutePath();
                new Thread(() -> {
                    System.out.println("上传文件"+path+"中");
                    upload(path);
                });
            } else {
                listFile(f);
            }
        }
    }
}
