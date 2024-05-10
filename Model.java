// Model.java
import java.util.ArrayList;
import java.util.List;

public class Model {
    private String name;
    private double price;
    private String description;
    private List<Model> modelList;

    public Model() {
        this.modelList = new ArrayList<>();
    }

    // Getter and setter methods for name, price, and description
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Method to add a model to the list
    public void addModel(Model model) {
        modelList.add(model);
    }

    // Method to get the list of models
    public List<Model> getModelList() {
        return modelList;
    }
    
    // Override toString() method to return model details
    @Override
    public String toString() {
        return name + ", Price: " + price + ", Description: " + description;
    }
}










