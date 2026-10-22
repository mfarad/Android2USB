package ch.xs3.android2usb;
import org.junit.Test;
import static org.junit.Assert.*;
public class CopyRulesTest {
 @Test public void rejectsSameAndNestedFolders(){assertTrue(CopyRules.overlap("primary:DCIM","primary:DCIM"));assertTrue(CopyRules.overlap("primary:DCIM","primary:DCIM/Camera"));assertTrue(CopyRules.overlap("primary:DCIM/Camera","primary:DCIM"));}
 @Test public void acceptsSiblingFoldersAndSeparateDrives(){assertFalse(CopyRules.overlap("primary:DCIM","primary:DCIM2"));assertFalse(CopyRules.overlap("primary:DCIM","ABCD:DCIM"));}
 @Test public void rejectsVolumeRootOverlap(){assertTrue(CopyRules.overlap("primary:","primary:DCIM"));assertTrue(CopyRules.overlap("ABCD:Photos","ABCD:"));assertFalse(CopyRules.overlap("ABCD:","EFGH:Photos"));}
 @Test(expected=IllegalArgumentException.class) public void rejectsPathTraversal(){CopyRules.safeName("../photo.jpg");}
 @Test public void acceptsUnicodeNames(){assertEquals("Été 2026.jpg",CopyRules.safeName("Été 2026.jpg"));}
}
