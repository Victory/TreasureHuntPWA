package org.dfhu.thpwa.context;

import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class ThSessionProvider {
  public static final String TH_SESSION = "th-session";

  // key (Cookie), Session pair
  private static final Map<String, ThSession> sessions = new HashMap<>();

  /**
   * Get or create if not found user sesssion
   * @param req - user's request
   * @param res - user's res object
   * @return - user session
   */
  synchronized public ThSession getSession(Request req, Response res) {
    String cookie = req.cookie(TH_SESSION);
    if (cookie == null) {
      cookie = generateSessionCookie();
      res.cookie(TH_SESSION, cookie);
    }

    if (sessions.containsKey(cookie)) {
      return sessions.get(cookie);
    }

    ThSession thSession = ThSession.newInstance(req, res);
    sessions.put(cookie, thSession);
    return sessions.get(cookie);
  }

  private String generateSessionCookie() {
    return "th" + Math.floor(Math.random() * 1000000000);
  }
}
