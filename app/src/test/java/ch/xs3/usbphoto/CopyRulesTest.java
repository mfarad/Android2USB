package ch.xs3.usbphoto;
import org.junit.Test;
import static org.junit.Assert.*;
public class CopyRulesTest {
 @Test public void rejectsSameAndNestedFolders(){assertTrue(CopyRules.overlap("primary:DCIM","primary:DCIM"));assertTrue(CopyRules.overlap("primary:DCIM","primary:DCIM/Camera"));assertTrue(CopyRules.overlap("primary:DCIM/Camera","primary:DCIM"));}
 @Test public void acceptsSiblingFoldersAndSeparateDrives(){assertFalse(CopyRules.overlap("primary:DCIM","primary:DCIM2"));assertFalse(CopyRules.overlap("primary:DCIM","ABCD:DCIM"));}
 @Test(expected=IllegalArgumentException.class) public void rejectsPathTraversal(){CopyRules.safeName("../photo.jpg");}
 @Test public void acceptsUnicodeNames(){assertEquals("Été 2026.jpg",CopyRules.safeName("Été 2026.jpg"));}
}
