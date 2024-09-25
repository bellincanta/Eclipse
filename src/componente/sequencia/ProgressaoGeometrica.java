package componente.sequencia;

public class ProgressaoGeometrica implements IProgressaoGeometrica {
	private int vi, rz;
	private int vc;

	public ProgressaoGeometrica() {
		vi = 1;
		rz = 2;
		vc = vi;
	}

	@Override
	public int getVi() {
		return vi;
	}

	@Override
	public void setVi(int vi) {
		this.vi = vi;

	}

	@Override
	public int getRz() {
		return rz;
	}

	@Override
	public void setRz(int rz) {
		this.rz = rz;

	}

	@Override
	public int primeiro() {
		vc = vi;
		return vc;
	}

	@Override
	public int proximo() {
		vc *= rz;
		return vc;
	}

}