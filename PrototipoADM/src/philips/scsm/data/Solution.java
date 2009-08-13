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
    private boolean haveTicket;
    private boolean needTicket;
    private boolean haveJarPatch;
    private boolean haveTxtPatch;
    private boolean haveEmailPatch;
    private boolean haveCodeCVS;
    private boolean haveCodePatch;

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
     * @return the haveTicket
     */
    public boolean isHaveTicket() {
        return haveTicket;
    }

    /**
     * @param haveTicket the haveTicket to set
     */
    public void setHaveTicket(boolean haveTicket) {
        this.haveTicket = haveTicket;
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
     * @return the haveJarPatch
     */
    public boolean isHaveJarPatch() {
        return haveJarPatch;
    }

    /**
     * @param haveJarPatch the haveJarPatch to set
     */
    public void setHaveJarPatch(boolean haveJarPatch) {
        this.haveJarPatch = haveJarPatch;
    }

    /**
     * @return the haveTxtPatch
     */
    public boolean isHaveTxtPatch() {
        return haveTxtPatch;
    }

    /**
     * @param haveTxtPatch the haveTxtPatch to set
     */
    public void setHaveTxtPatch(boolean haveTxtPatch) {
        this.haveTxtPatch = haveTxtPatch;
    }

    /**
     * @return the haveEmailPatch
     */
    public boolean isHaveEmailPatch() {
        return haveEmailPatch;
    }

    /**
     * @param haveEmailPatch the haveEmailPatch to set
     */
    public void setHaveEmailPatch(boolean haveEmailPatch) {
        this.haveEmailPatch = haveEmailPatch;
    }

    /**
     * @return the haveCodeCVS
     */
    public boolean isHaveCodeCVS() {
        return haveCodeCVS;
    }

    /**
     * @param haveCodeCVS the haveCodeCVS to set
     */
    public void setHaveCodeCVS(boolean haveCodeCVS) {
        this.haveCodeCVS = haveCodeCVS;
    }

    /**
     * @return the haveCodePatch
     */
    public boolean isHaveCodePatch() {
        return haveCodePatch;
    }

    /**
     * @param haveCodePatch the haveCodePatch to set
     */
    public void setHaveCodePatch(boolean haveCodePatch) {
        this.haveCodePatch = haveCodePatch;
    }
}
