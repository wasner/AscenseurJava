public class State {
	private InitState initState;
	private ParamState paramState;
	
	public State(Window window)
	{
		this.initState = new InitState(window, this);
		this.paramState = new ParamState(window, this);
	}
	
	public InitState getInitState()
	{
		return this.initState;
	}
	
	public ParamState getParamState()
	{
		return this.paramState;
	}
}
