package io.github.oaschi.paperwarp.commands.parser;

public class MissingArgumentException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4742793804115924451L;
	private Option opt;
	public MissingArgumentException(Option opt){
		super();
		this.opt = opt;
	}
	public Option getOpt() {
		return opt;
	}
	public void setOpt(Option opt) {
		this.opt = opt;
	}
}
