package xcal.cs.math;

import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import xcal.cs.math.model.SubstractionRequest;
import xcal.cs.math.model.SubstractionResponse;

public class SubstractionTest {

  private final RestTemplate client = TestSupport.CLIENT;

  @Test(dataProvider = "successCases")
  public void testSuccess(int minuend, int substrachend, int diff) {
    SubstractionRequest request = new SubstractionRequest(minuend, substrachend);
    SubstractionResponse response =
        client.postForEntity("/substract", request, SubstractionResponse.class).getBody();

    Assert.assertEquals(response.getDifference(), Integer.valueOf(diff));
  }

  @DataProvider(name = "successCases")
  private static Object[][] getSuccessCases() {
    return new Object[][] {
        { 1, 1, 0 },
        { 0, 0, 0 },
        { 0, 1, -1 },
        { 8, 0, 8 },
        { 2, -2, 4 },
        { -2, 5, -7}
    };
  }

  @Test(dataProvider = "overflowCases")
  public void testOverflow(int minuend, int substrachend) {
    try {
      SubstractionRequest request = new SubstractionRequest(minuend, substrachend);
      client.postForEntity("/substract", request, SubstractionResponse.class);
      Assert.fail("Expected exception not thrown");
    } catch (HttpStatusCodeException e) {
      Assert.assertEquals(e.getRawStatusCode(), 400);
    }
  }

  @DataProvider(name = "overflowCases")
  private static Object[][] getOverflowCases() {
    return new Object[][] {
        {  Integer.MAX_VALUE, -1 },
        {  Integer.MIN_VALUE, 1 },
        {  Integer.MAX_VALUE, -10 }
    };
  }
}
