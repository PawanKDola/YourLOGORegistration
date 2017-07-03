package com.practice.yourLogo.Pages;

import com.practice.yourLogo.PreRequisites.WebElemRepository;

public class YourLogoCommOps extends YourLogoPageBase
{
		public YourLogoCommOps(String idCol) {
			this.idCol = idCol;
			loadTestData();
		}
		
		public String getValueFromSheet(String dataKey){
			String dataVal = WebElemRepository.dataLocs.get(dataKey);
			return dataVal;
		}
}
