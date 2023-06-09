package Services;

import Animal.Animal;
import FamilyTrees.FamilyTree;
import Humans.Human;
import Sex.Sex;
import WorkingFiles.InOutFiles;
import WorkingFiles.inOutSerialObject;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private int id;
    private FamilyTree<Animal> familyGroup;

    public Service(FamilyTree familyGroup) {
        this.familyGroup = familyGroup;

    }

    public Service() {
        this.familyGroup = new FamilyTree<Animal>();

    }

    public FamilyTree getFamilyGroup() {

        return  familyGroup;
    }

    public void addHuman(String firstName, String lastname, String strDateOfBirth, Sex sex, Human mather, Human father) {
        id++;
        familyGroup.add(new Human(id, firstName, lastname, LocalDate.parse(strDateOfBirth), sex, mather, father));
    }

    public void addHuman(String firstName, String lastname, String strDateOfBirth, Sex sex) {
        id++;
        familyGroup.add(new Human(id, firstName, lastname, LocalDate.parse(strDateOfBirth), sex, null, null));
    }


 public boolean delHumanID(int id){
    familyGroup.delHumanID(id);
     return true;
 }

 public List<Animal> searchHuman(String lastname){
        return familyGroup.searchHuman(lastname);
 }
    public void sortByID() {
        familyGroup.sortByID();
    }

    public void sortByLastName() {
        familyGroup.sortByLastName();
    }

    public void saveFamilyGroup(String str) {
        InOutFiles save = new inOutSerialObject();
        save.saveFile(this.familyGroup, str);
    }

    public void loadFamilyGroup(String str) {
        InOutFiles load = new inOutSerialObject();
        this.familyGroup = load.loadFile(str);
        id = 1;
        for (Animal item : this.familyGroup) {
            if (id < item.getId()) id = item.getId();
        }
    }
}



