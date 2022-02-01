package framework.baseformpackage;

import framework.elementspackage.BaseElement;
import framework.utilpackage.logger.Log;

public abstract class BaseForm {
    private final BaseElement uniqueElement;
    protected final String name;

    public BaseForm(BaseElement uniqueElement, String name) {
        this.uniqueElement = uniqueElement;
        this.name = name;
    }

    public boolean isPageOpen() {
        Log.getLogger().info(name + " was opened");

        return uniqueElement.isExist();
    }

    public boolean isPageNotOpen() {
        Log.getLogger().info(name + " was closed");

        return uniqueElement.isNotExist();
    }
}
