package io.github.oaschi.paperwarp.commands.parser;

import java.util.Arrays;
import java.util.ListIterator;


public class Parser {
	
	private Options options;
	protected CommandLine cmd;
	
	public Parser(){
		
	}

	public CommandLine parse(Options options, String[] args) throws UnknownOptionException, MissingArgumentException{
		this.options = options;
		for(OptionGroup group : options.getOptionGroups().values()){
			group.setSelected(null);
		}
		
		if(args == null){
			args = new String[0];
		}
		
		cmd = new CommandLine();
		
		ListIterator<String> iterator = Arrays.asList(args).listIterator();
		boolean firstOptionReached = false;
		
		while(iterator.hasNext()){
			String token = iterator.next();
			
			if(token.startsWith("-")){
				processOption(token, iterator);
				firstOptionReached = true;
			}
			else if(!firstOptionReached){
				cmd.add(token);
			}
		}
		
		return cmd;
	}
	
	private void processOption(String token, ListIterator<String> iter) throws UnknownOptionException, MissingArgumentException{
		if(!getOptions().hasOption(token)){
			throw new UnknownOptionException(token);
		}
		Option opt = getOptions().getOption(token).clone();
		setSelected(opt);
		
		if(opt.isArgRequired()){
			processArgs(opt, iter);
		}
		
		cmd.add(opt);
	}
	
	private void processArgs(Option opt, ListIterator<String> iter) throws MissingArgumentException {
		while(iter.hasNext()){
			String token = iter.next();
			
			if(token.startsWith("-")){
				iter.previous();
				break;
			}
			
			opt.addValue(token);
		}
		
		if(opt.getValue().length() == 0){
			throw new MissingArgumentException(opt);
		}
	}

	private void setSelected(Option opt){
		OptionGroup group = getOptions().getOptionGroup(opt);
		if(group != null){
			group.setSelected(opt);
		}
	}

	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}
	
}
