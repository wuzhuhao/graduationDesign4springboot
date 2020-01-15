package com.graduationaldesign.graduation.dto;

import com.graduationaldesign.graduation.pojo.Academy;
import com.graduationaldesign.graduation.util.BeanUtil;
import java.io.Serializable;


public class TAcademyDTO implements Serializable {
        
        private static final long serialVersionUID = 1L;
        /**学院名称*/
        private String acaName;
        /**学院介绍*/
        private String acaIntroduce;
        
        public String getAcaName() {
            return this.acaName;
        }
        
        public void setAcaName(String acaName) {
            this.acaName = acaName;
        }
        
        public String getAcaIntroduce() {
            return this.acaIntroduce;
        }
        
        public void setAcaIntroduce(String acaIntroduce) {
            this.acaIntroduce = acaIntroduce;
        }
        
        public Academy toModel() {
            Academy model = new Academy();
			BeanUtil.convert(this, model);
			return model;
        }
    
}