package cn.llynsyw.junit.junit2;

public class Largest {

	public int getLargest(int[] array) throws Exception {
		if (array == null || array.length == 0) {
			throw new Exception("???��?????");
		}

		int result = array[0];

		for (int i = 0; i < array.length; i++) {
			if (result < array[i])
				result = array[i];

		}

		return result;
	}

}
