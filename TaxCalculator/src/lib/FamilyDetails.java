
package lib;
import java.util.LinkedList;
import java.util.List;
public class FamilyDetails {
    private String spouseName;
    private String spouseIdNumber;
    private List<String> childNames;
    private List<String> childIdNumbers;

	public FamilyDetails() {
        childNames = new LinkedList<String>();
        childIdNumbers = new LinkedList<String>();
    }

    public String getSpouseIdNumber() {
        return this.spouseIdNumber;
    }
	public void addChild(String childName, String childIdNumber) {
        childNames.add(childName);
        childIdNumbers.add(childIdNumber);
    }

	public boolean hasSpouse() {
        return spouseIdNumber != null && !spouseIdNumber.isEmpty();
    }

	public int getChildCount() {
        return childIdNumbers.size();
    }
}
