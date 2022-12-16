package fanur;

import fanur.controllers.UserController;
import fanur.model.FileOperation;
import fanur.model.FileOperationImpl;
import fanur.model.Repository;
import fanur.model.RepositoryFile;
import fanur.views.ViewUser;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("users.txt");
        Repository repository = new RepositoryFile(fileOperation);
        UserController controller = new UserController(repository);
        ViewUser view = new ViewUser(controller);
        view.run();
    }
}