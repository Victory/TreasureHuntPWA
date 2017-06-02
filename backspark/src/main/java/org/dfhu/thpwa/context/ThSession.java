package org.dfhu.thpwa.context;

import spark.Request;
import spark.Response;

public class ThSession {
  private final Request req;
  private final Response res;

  private ThSession(Request req, Response res) {
    this.req = req;
    this.res = res;
  }

  public Request getReq() {
    return req;
  }

  public Response getRes() {
    return res;
  }

  /** Stub not implemented */
  public void logout() {
  }

  static ThSession newInstance(Request req, Response res) {
    return new ThSession(req, res);
  }
}
