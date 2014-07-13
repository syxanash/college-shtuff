/**
 * @author Simone Marzulli
 *         Antonio Antonino
 *
 * @date 13/06/2014
*/

public class DynamicScope {
    private String varName;
    private int scopeNumber;
    private boolean active;

    public DynamicScope(String varName, int scopeNumber) {
        this.varName = varName;
        this.scopeNumber = scopeNumber;
        this.active = true;
    }

    // set methods

    public void setName(String varName) {
        this.varName = varName;
    }

    public void setScopeNumber(int scopeNumber) {
        this.scopeNumber = scopeNumber;
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }

    // getter

    public boolean getStatus() {
        return active;
    }

    public int getScopeNumber() {
        return scopeNumber;
    }

    public String getName() {
        return varName;
    }
}