interface IClient {
  /**
   * Requests a parking session
   * 
   * @return {Session} the requested session
   */
  public Session requestCheckIn();

  /**
   * Completes a parking session
   * 
   * @param session  {Session} the client's session
   * @param exitTime {String} the exit date time
   */
  public void requestCheckOut(Session session, String exitTime);

  /**
   * Recieves a receipt and finalizes payment for the service
   * 
   * @param receipt {Receipt} the client's receipt
   */
  public void payForService(Receipt receipt);
}
