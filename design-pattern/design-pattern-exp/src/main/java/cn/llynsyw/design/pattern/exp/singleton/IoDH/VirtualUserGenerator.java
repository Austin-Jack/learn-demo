package cn.llynsyw.design.pattern.exp.singleton.IoDH;

public class VirtualUserGenerator {
	private VirtualUserGenerator() {
	}

	private static class Holder {
		private static final VirtualUserGenerator INSTANCE = new VirtualUserGenerator();
	}

	public static VirtualUserGenerator getInstance() {
		return Holder.INSTANCE;
	}
}
