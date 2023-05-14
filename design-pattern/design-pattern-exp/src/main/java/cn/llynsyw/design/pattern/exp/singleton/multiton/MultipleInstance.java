package cn.llynsyw.design.pattern.exp.singleton.multiton;

public class MultipleInstance {
    /*˽�й��췽��*/
    private MultipleInstance() {
    }

    /*ָ�������ĸ���*/
    private final static int INSTANCE_COUNT = 3;

    /*ö������*/
    private enum InstanceHolder {
        /*�����ĳ�����*/
        HOLDER;
        private MultipleInstance[] instances;

        private InstanceHolder() {
            /*��ʼ���������� */
            instances = new MultipleInstance[INSTANCE_COUNT];
            for (int i = 0; i < INSTANCE_COUNT; i++) {
                instances[i] = new MultipleInstance();
            }
        }

        private MultipleInstance getInstance(int index) {
            return instances[index];
        }
    }

    /*��ȡָ��λ�õ�һ��ʵ��*/
    public static MultipleInstance getInstance(int index) {
        if (index < INSTANCE_COUNT && index >= 0) {
            return InstanceHolder.HOLDER.getInstance(index);
        } else {
            System.out.println("index is illegal");
        }
        return null;
    }

    public enum Test {
        A {

        }, B, C;

        void tes() {

        }
    }

    public static void main(String[] args) {

    }
}

