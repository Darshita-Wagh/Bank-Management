package bank_management;

public class Customer {
	private int cid;
	private String cname;
	private String acc_type;
	private long bal;
	private String phoneno;
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public long getBal() {
		return bal;
	}

	public void setBal(long bal) {
		this.bal = bal;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	public Customer(String cname, String acc_type, long bal, String phoneno) {
		super();
		this.cname = cname;
		this.acc_type = acc_type;
		this.bal = bal;
		this.phoneno = phoneno;
	}

	public Customer(String cname, String acc_type, String phoneno) {
		super();
		this.cname = cname;
		this.acc_type = acc_type;
		this.phoneno = phoneno;
	}

	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", acc_type=" + acc_type + ", bal=" + bal + ", phoneno="
				+ phoneno + "]";
	}
	
}
