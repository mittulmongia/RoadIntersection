import java.util.Date;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VehicleRNG extends Thread{
		
		private Helper helper;
		private LinkedList<Phases> phaseList;
		private Random random;
		
		private GUIModel model;
		private DefaultTableModel vModel;
		private ReportFile file = ReportFile.getInstance();
		
		
		public VehicleRNG(Helper helper, LinkedList<Phases> phaseList, GUIModel model){
			this.helper = helper;
			this.phaseList = phaseList;
			this.random = new Random();
			this.model = model;
			this.vModel = model.getVehicleModel();
			
			
			
		}
		
		private synchronized void rngVehicleCreator(Helper helper) throws PhaseException, NumberFormatException, InaccurateDataException, DuplicateIDException {
			ArrayList<String> vehicleDetails = new ArrayList<String>();
			vehicleDetails = helper.randomlyGenerateVehicles();
			helper.evaluateVehicleFile(vehicleDetails, phaseList);
			Vehicles car = helper.createVehicle(vehicleDetails, phaseList);
			boolean sortedPhase = helper.findPhase(car, phaseList);
			if (sortedPhase) {
				System.out.println(car.getPlateNumber() + " has been added to the appropriate phase");
				model.addNewVehicle(car.getPlateNumber());
			}else {
				throw new PhaseException(car.getPlateNumber() + " could not be sorted, check the segment and direction for format errors. " + car.getSegment() + ", " + car.getCrossingDirection());
			}
			helper.checkCarSegment(car, model);
			helper.updateSegmentTable(car.getSegment(), model);
			file.writeToFile(car.getPlateNumber() + " has been created");
			model.updateModel(vModel, vehicleDetails.toArray());
			model.addToTotalEmissions(car.getVehicleEmission());
		}
		
		@Override
		public void run() {
			while (true) {
				try {
					rngVehicleCreator(helper);
					try {
		                Thread.sleep(random.nextInt(1000) + 1000); // Generate a new vehicle every 1-6 seconds
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
				} catch (NumberFormatException | PhaseException | InaccurateDataException | DuplicateIDException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
		
		
			
		
}
