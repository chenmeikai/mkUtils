/**
 * Copyright © 2018
 *
 * @Package: com.meikai.utils
 * @date: 2018年4月10日 下午2:35:09
 */
package com.meikai.utils;

import com.chenmeikai.utils.RSA.SecurityUtils;

/**
 * @Description:TODO
 * @author: cmk
 * @date: 2018年4月10日 下午2:35:09
 */
public class RsaTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
		
		
		/*try {
		String text=SecurityUtils.encryptByPublicString("cmk123","MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCTTbSgmLTHVKrKxu7hHiKmPjRd v9iIJx9qgO7j8bgmZkWU/ion6OSOQvDrZZnuN57kmOD91PHzV+vWFvgcHsOe07/q tZqqxmBL5cbRXabNaiSdq117l/JDPWdKRYTLJck2manzgQv/Nm9cgRYIneaOgsgp +xiwfQYe/L7nhb6tJwIDAQAB");
		System.out.println("密文:"+text);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
        try {
            String text = SecurityUtils.decryptByPrivateString("A0A1JFKATc584urmL7Yh0PjcEMtzTMOEb/FSQtS4GubCdUtddONDwiv99t69p9vQzGDS2KIygfvTu/F5umom6kQYhQHDVBPpT8lRfkh/1auKJFVOc4KvBWCxVgsCOCL/pQvIyd5Kkk7Dy90g++ov1J/FFJvRCmD0yM+ZZMDEjxk=", "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKsP3j2l6bNdMPSeICnMSlI4rHJSX/IJoFQy6ujDUvihY6qzzJ+7fVUlXu3onfXIcSpeai35YCWDTjlxCdWJQuEyV9cHs7gkyzabL9jd3yRlQ1S9xZvZashr12/pUYGO0Bm06IPU6haQPqwEb7n9pf0GqfiKez1sJK0KH1UTStEPAgMBAAECgYBoHoZ1G5F9vRFZMw38ov3xwdEk3ILNvZI67asR9iGAeCtD8aBw8Ru+QbrgMCBFQ7Wtxj32sb0V2DA6wlTsBloP2+gyAa8dT9YTjfis0+9pLS7HVlFnz5MKquw+FB9ZWlEGOl6GWiP9fjj9+yLCTgXqxwxuLlEoVVLBac5AvPYRMQJBAOk0ZLbSovAhVu1LtJkkuhyLpiLv8huF/p9rvYt7/wq1H1mWJv1IH+FnCusW+I9mPxyzpztnKosiVMJd9ZTmAx0CQQC7yHHhW+W8FHL6ETOGlaXSvFnLg553Udxvg1HyCLaUAYJdCW2JaYQtjJsNgf+9srPU/pAU3+TjEZNbiWURvOEbAkAjY1D5MUOKfvSq87cHGjynwkVGvfSWWqIF3RqZRQqxvERymsd13fEAiltsy0KSuChRma2B5SjejiogiJOQscq9AkEAt/68jvtzjClhS2OFYC7Lb0R8m6vYnsOIQX+j0Ir3EuizqqOtP4IzMEpgNwkU4/Pwvxe7Z6jF5jP3di6W6J1w1wJAYeV/xHrYQnGpvL9IgyF+Nmy+XJeyCNzLxtZE5PWPxzfqIFAG3BSVA8IdJH5y0sE5XTm+A+JkmevwporCxWO94w==");
            System.out.println("明文:" + text);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
