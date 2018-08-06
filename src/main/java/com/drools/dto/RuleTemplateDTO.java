package com.drools.dto;

import com.drools.model.TemplateType;

/**
 * @author sen.huang
 *         Date: 2018/8/6
 */
public class RuleTemplateDTO {
    private String id;
    private String name;
    private TemplateType type;
    private TemplateDTO templateDTO;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TemplateType getType() {
        return type;
    }

    public void setType(TemplateType type) {
        this.type = type;
    }

    public TemplateDTO getTemplateDTO() {
        return templateDTO;
    }

    public void setTemplateDTO(TemplateDTO templateDTO) {
        this.templateDTO = templateDTO;
    }
}
