package star16m.utils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import star16m.utils.file.FileUtil;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    public void testFileNameTest() {
        String fileName = FileUtil.getFileName("C:\\programming\\tools\\anyframe-core-5.5.0.zip");
        String fileName2 = FileUtil.getFileName("/app/test/haha/anyframe-core-5.5.0.zip");
        assertEquals("anyframe-core-5.5.0.zip", fileName);
        assertEquals("anyframe-core-5.5.0.zip", fileName2);
    }
    public void testBaseNameTest() {
        String fileName = FileUtil.getBaseName("C:\\programming\\tools\\anyframe-core-5.5.0.zip");
        String fileName2 = FileUtil.getBaseName("/app/test/haha/anyframe-core-5.5.0.zip");
        assertEquals("anyframe-core-5.5.0", fileName);
        assertEquals("anyframe-core-5.5.0", fileName2);
    }
        
}
