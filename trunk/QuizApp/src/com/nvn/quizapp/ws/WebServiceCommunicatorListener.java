package com.nvn.quizapp.ws;

import com.nvn.quizapp.ws.BaseWSControl.WebServiceFlag;




/**
 * 
 * Interface for the communication Between background service thread and the
 * front End UI. Activity can implement the interface for getting call backs on
 * service events.
 * 
 * @author Architact
 * @version 1.0
 */

public interface WebServiceCommunicatorListener {

	/**
	 * This method will be called when communicator is opening the connection,
	 * use it to show any dialog or status indicator you want
	 */
	public void onConnectionOpen(BaseWSControl wsControl, WebServiceFlag flag);

	/**
	 * This method will be called for any errors occured during the operation
	 * error will be passed to the activity.
	 * 
	 * @param error
	 */
	public void onConnectionError(BaseWSControl wsControl, WebServiceFlag flag,
			String error);

	/**
	 * This method will be called when communicator has completed the request
	 * any result will be passed to the activity.
	 * 
	 */
	public void onConnectionDone(BaseWSControl wsControl, WebServiceFlag flag,
			Object result);

	public void onUpdateData(BaseWSControl wsControl, WebServiceFlag flag,
			Object data);

}
