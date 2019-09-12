package quicksort;

/**
 * CatalogueItem, creates a CatalogueItem object.
 * @author Matthew Dods 420190038
 */
class CatalogueItem {
      
    private Integer id;
    private String itemName;
    private String category;
    
    /**
     * id, returns object id.
     * @return - returns id
     */
    public int getItemId(){
    return id;
    }
    
    /**
     * getItemName, returns object item name.
     * @return - returns itemName.
     */
    public String getItemName(){
    return itemName;
    }
    
    /**
     * getCategory, returns object category. 
     * @return - returns category
     */
    public String getCategory(){
    return category;
    }
    
    /**
     * CatalogueItem, constructor.
     */
    public CatalogueItem(Integer newId, String newName, String newCategory){
        id = newId;
        itemName = newName;
        category = newCategory;
    }
    
}
