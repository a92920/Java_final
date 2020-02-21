package fr.epita.java;

import java.io.IOException;

import tech.tablesaw.api.NumericColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.Scatter3DPlot;
import tech.tablesaw.plotly.api.ScatterPlot;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.components.Layout;
import tech.tablesaw.plotly.components.Marker;
import tech.tablesaw.plotly.traces.HistogramTrace;
import tech.tablesaw.plotly.traces.ScatterTrace;
import tech.tablesaw.table.TableSliceGroup;

public class Main {

	public static void main(String[] args) throws IOException {
		// Class Survival
				Table titanic = Table.read().csv("data/input.csv");

			    Layout layout =
			        Layout.builder()
			            .title("Class survival")
			            .barMode(Layout.BarMode.GROUP)
			            .showLegend(true)
			            .build();

			    TableSliceGroup groups = titanic.splitOn("Survived");

			    Table t1 = groups.get(0).asTable();
			    Table t2 = groups.get(1).asTable();

			    HistogramTrace trace1 =
			        HistogramTrace.builder(t1.nCol("Pclass"))
			            .name("Died")
			            .opacity(.75)
			            .nBinsY(24)
			            .marker(Marker.builder().color("#FF4136").build())
			            .build();

			    HistogramTrace trace2 =
			        HistogramTrace.builder(t2.nCol("Pclass"))
			            .name("Survived")
			            .opacity(.75)
			            .nBinsY(24)
			            .marker(Marker.builder().color("#7FDBFF").build())
			            .build();

			    Plot.show(new Figure(layout, trace1, trace2));
			    
			    
			 // Sex Survival

			 	    Layout layout1 =
			 	        Layout.builder()
			 	            .title("Gender survival")
			 	            .barMode(Layout.BarMode.GROUP)
			 	            .showLegend(true)
			 	            .build();

			 	    TableSliceGroup groups1 = titanic.splitOn("Sex");

			 	    Table t11 = groups1.get(0).asTable();
			 	    Table t21 = groups1.get(1).asTable();
			 	    HistogramTrace trace11 =
			 	        HistogramTrace.builder(t11.nCol("Survived"))
			 	            .name("Male")
			 	            .opacity(.75)
			 	            .nBinsY(24)
			 	            .marker(Marker.builder().color("#FF4136").build())
			 	            .build();

			 	    HistogramTrace trace21 =
			 	        HistogramTrace.builder(t21.nCol("Survived"))
			 	            .name("Female")
			 	            .opacity(.75)
			 	            .nBinsY(24)
			 	            .marker(Marker.builder().color("#7FDBFF").build())
			 	            .build();

			 	    Plot.show(new Figure(layout1, trace11, trace21));
			 	    
			 	    
			 	    
			 	    
			 	// age survival
			 	   Layout layout2 =
			 		        Layout.builder()
			 		            .title("Age survival")
			 		            .barMode(Layout.BarMode.GROUP)
			 		            .showLegend(true)
			 		            .build();

			 		    TableSliceGroup groups2 = titanic.splitOn("Survived");

			 		    Table t22 = groups2.get(0).asTable();
			 		    Table t23 = groups2.get(1).asTable();

			 		    HistogramTrace trace22 =
			 		        HistogramTrace.builder(t22.nCol("Age"))
			 		            .name("Died")
			 		            .opacity(.75)
			 		            .nBinsY(24)
			 		            .marker(Marker.builder().color("#FF4136").build())
			 		            .build();

			 		    HistogramTrace trace23 =
			 		        HistogramTrace.builder(t23.nCol("Age"))
			 		            .name("Survived")
			 		            .showLegend(true)
			 		            .opacity(.75)
			 		            .nBinsY(24)
			 		            .marker(Marker.builder().color("#7FDBFF").build())
			 		            .build();

			 		    Plot.show(new Figure(layout2, trace22, trace23));
			 		    
			 		    
			 		    
			 		   Plot.show(
			 				  Scatter3DPlot.create(
			 			            "Average retail price for champagnes by vintage and rating",
			 			            titanic,
			 			            "Fare",
			 			            "Parents/Children Aboard", 
			 			            "Age",
			 			            "Survived"
			 			            ));
		

	}

}
