package CaseStudy.Model.repository;

import java.io.IOException;

public interface IRepository {
    void addNew(Object obj) throws IOException;

    void displayList() throws IOException;
}
