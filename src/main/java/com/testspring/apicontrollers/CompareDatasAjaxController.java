package com.testspring.apicontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testspring.jsonview.Views;
import com.testspring.models.ajaxRequest.CompareDataForm;
import com.testspring.models.ajaxResponse.GraphInfo;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class CompareDatasAjaxController {

	@JsonView(Views.Public.class)
	@RequestMapping(value="/api/getGraphInfo")
	public List<GraphInfo> getGraphInfo(@RequestBody CompareDataForm compareDateForm) {
		String[] labels = {"2559", "2560"};
		int dataArray[][] = {
				{3, 20, 87, 65, 12, 23, 70, 100, 150, 20, 50, 45},
				{121, 219, 33, 45, 12, 3, 75, 52, 99, 143, 120, 125}	
		};
		List<GraphInfo> graphInfos = new ArrayList<GraphInfo>();
		
		for(int row = 0; row < dataArray.length; row++) {
			GraphInfo graphInfo = new GraphInfo();
			List<Integer> data = new ArrayList<Integer>();
			for(int col = 0; col < dataArray[row].length; col++) {
//				System.out.println("#S row: " + row + " col: " + col + " data: " + dataArray[row][col]);
				data.add(dataArray[row][col]);		
			}
			graphInfo.setData(data);
			graphInfo.setLabel(labels[row]);
			graphInfos.add(graphInfo);
		}
		System.out.println("#S dataArray: " + dataArray);
		return graphInfos;
	}
}
