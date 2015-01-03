/**
 * Created by Nicholas Hallahan on 1/2/2015.
 * nhallahan@spatialdev.com
 */

package com.spatialdev.osm.test;

import android.test.InstrumentationTestCase;

import com.spatialdev.osm.DataSet;
import com.spatialdev.osm.OsmXmlParser;

import java.io.InputStream;

public class OsmXmlParserTest extends InstrumentationTestCase {

    private InputStream in;
    private DataSet ds;

    public void setUp() throws Exception {
        super.setUp();
        in = getInstrumentation().getTargetContext().getResources().getAssets().open("test/osm/spatialdev_small.osm");
        ds = OsmXmlParser.parseFromInputStream(in);
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    // should be 83 nodes
    public void testNumberOfNodes() throws Exception {
        assertEquals(83, ds.getNodeCount());
    }

    // should be 10 ways
    public void testNumberOfWays() throws Exception {
        assertEquals(10, ds.getWayCount());
    }

    // should be 0 relations
    public void testNumberOfRelations() throws Exception {
        assertEquals(0, ds.getRelationCount());
    }

}
