interface IEmployee {
  /**
   * Starts a client's requested parking session
   * 
   * @param session   {Session} the requested session
   * @param enterTime {String} the enter date time
   * @return {int} the reserved space number
   */
  public int checkIn(Session session, String enterTime);

  /**
   * Closes a client's completed parking session and invoices the client for the
   * service
   * 
   * @param session {Session} the completed parking session
   * @return {Receipt} the client's receipt
   */
  public Receipt checkOut(Session session);
}
