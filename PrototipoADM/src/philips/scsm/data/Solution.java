package philips.scsm.data;

/**
 *
 * @author pablo.sierralta
 */
public class Solution {

    private String id;
    private String description;
    private String asigneed;
    private String status;
    private String resolution;
    private String opSys;
    private String priority;
    private String severity;
    private boolean hasTicket;
    private boolean needTicket;
    private boolean hasJarPatch;
    private boolean hasTxtPatch;
    private boolean hasEmailPatch;
    private boolean hasCodeCVS;
    private boolean hasCodePatch;

    public Solution(String id) {
        this.id = id;
    }

    public Solution(String id, String description) {
        this.id = id;
        this.description = description;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the asigneed
     */
    public String getAsigneed() {
        return asigneed;
    }

    /**
     * @param asigneed the asigneed to set
     */
    public void setAsigneed(String asigneed) {
        this.asigneed = asigneed;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the resolution
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * @param resolution the resolution to set
     */
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    /**
     * @return the opSys
     */
    public String getOpSys() {
        return opSys;
    }

    /**
     * @param opSys the opSys to set
     */
    public void setOpSys(String opSys) {
        this.opSys = opSys;
    }

    /**
     * @return the priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * @return the severity
     */
    public String getSeverity() {
        return severity;
    }

    /**
     * @param severity the severity to set
     */
    public void setSeverity(String severity) {
        this.severity = severity;
    }

    /**
     * @return the hasTicket
     */
    public boolean isHasTicket() {
        return hasTicket;
    }

    /**
     * @param hasTicket the hasTicket to set
     */
    public void setHasTicket(boolean hasTicket) {
        this.hasTicket = hasTicket;
    }

    /**
     * @return the needTicket
     */
    public boolean isNeedTicket() {
        return needTicket;
    }

    /**
     * @param needTicket the needTicket to set
     */
    public void setNeedTicket(boolean needTicket) {
        this.needTicket = needTicket;
    }

    /**
     * @return the hasJarPatch
     */
    public boolean isHasJarPatch() {
        return hasJarPatch;
    }

    /**
     * @param hasJarPatch the hasJarPatch to set
     */
    public void setHasJarPatch(boolean hasJarPatch) {
        this.hasJarPatch = hasJarPatch;
    }

    /**
     * @return the hasTxtPatch
     */
    public boolean isHasTxtPatch() {
        return hasTxtPatch;
    }

    /**
     * @param hasTxtPatch the hasTxtPatch to set
     */
    public void setHasTxtPatch(boolean hasTxtPatch) {
        this.hasTxtPatch = hasTxtPatch;
    }

    /**
     * @return the hasEmailPatch
     */
    public boolean isHasEmailPatch() {
        return hasEmailPatch;
    }

    /**
     * @param hasEmailPatch the hasEmailPatch to set
     */
    public void setHasEmailPatch(boolean hasEmailPatch) {
        this.hasEmailPatch = hasEmailPatch;
    }

    /**
     * @return the hasCodeCVS
     */
    public boolean isHasCodeCVS() {
        return hasCodeCVS;
    }

    /**
     * @param hasCodeCVS the hasCodeCVS to set
     */
    public void setHasCodeCVS(boolean hasCodeCVS) {
        this.hasCodeCVS = hasCodeCVS;
    }

    /**
     * @return the hasCodePatch
     */
    public boolean isHasCodePatch() {
        return hasCodePatch;
    }

    /**
     * @param hasCodePatch the hasCodePatch to set
     */
    public void setHasCodePatch(boolean hasCodePatch) {
        this.hasCodePatch = hasCodePatch;
    }

    
}
