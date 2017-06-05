package org.dfhu.thpwa.context;

import org.junit.Test;
import spark.Request;
import spark.Response;

import static junit.framework.TestCase.assertNotNull;
import static org.powermock.api.mockito.PowerMockito.mock;

public class ThSessionProviderTest {

  @Test
  public void setsCookie() {
    ThSessionProvider thSessionProvider = new ThSessionProvider();
    Request req = mock(Request.class);
    Response res = mock(Response.class);
    ThSession session = thSessionProvider.getSession(req, res);
    String cookie = session.getReq().cookie(ThSessionProvider.TH_SESSION);
    assertNotNull(cookie);
  }
}