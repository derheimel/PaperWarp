package io.github.oaschi.paperwarp.commands.parser;

public class UnknownOptionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5557608136901547913L;
	
	private String opt;

	public UnknownOptionException(String opt){
		super();
		this.opt = opt;
	}

	public String getOpt() {
		return opt;
	}

	public void setOpt(String opt) {
		this.opt = opt;
	}
	
}
