import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Make } from 'src/app/model/make.model';
import { Model } from 'src/app/model/model.model';
import { VehicleType } from 'src/app/model/vehicleType.model';
import { DataService } from 'src/app/services/data.service';
import { MakeService } from 'src/app/services/make.service';
import { ModelService } from 'src/app/services/model.service';
import { VehicleTypeService } from 'src/app/services/vehicle-type.service';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent implements OnInit {

  val = "asd"
  subscription: Subscription;

  page: number = 0;

  states: string[] = [
    'Alabama', 'Alaska', 'Arizona', 'Arkansas', 'California', 'Colorado', 'Connecticut', 'Delaware',
    'Florida', 'Georgia', 'Hawaii', 'Idaho', 'Illinois', 'Indiana', 'Iowa', 'Kansas', 'Kentucky',
    'Louisiana', 'Maine', 'Maryland', 'Massachusetts', 'Michigan', 'Minnesota', 'Mississippi',
    'Missouri', 'Montana', 'Nebraska', 'Nevada', 'New Hampshire', 'New Jersey', 'New Mexico',
    'New York', 'North Carolina', 'North Dakota', 'Ohio', 'Oklahoma', 'Oregon', 'Pennsylvania',
    'Rhode Island', 'South Carolina', 'South Dakota', 'Tennessee', 'Texas', 'Utah', 'Vermont',
    'Virginia', 'Washington', 'West Virginia', 'Wisconsin', 'Wyoming'
  ];

  regs: string[] = [
    '2000', '2001', '2002', '2003', '2004', '2005', '2006', '2007', '2008', '2009', '2010', '2011',
    '2012', '2013', '2014', '2015', '2016', '2017', '2018', '2019', '2020', '2021', '2022'
  ]

  firstRegFrom: string = "1886";
  firstRegTo: string = String(Number(this.regs[this.regs.length - 1]) + 1);

  makes: Make[] = [];
  make: Make = new Make({ id: 0, name: "None" });

  models: Model[] = [];
  model: Model = new Model({ id: 0, name: 'None', makeId: 0 })

  priceFrom: number;
  priceTo: number;

  ccFrom: number;
  ccTo: number;

  hpFrom: number;
  hpTo: number;

  kmFrom: number;
  kmTo: number;

  vehicleTypes: VehicleType[] = [];
  type: VehicleType = new VehicleType({ id: 0, name: '' })

  constructor(
    private data: DataService,
    private makeService: MakeService,
    private modelService: ModelService,
    private vehicleTypeService: VehicleTypeService,

  ) { }

  ngOnInit(): void {
    this.subscription = this.data.currentMessage.subscribe(message => this.val = message)

    this.loadAllMakes();
    this.loadAllVehicleTypes();
  }

  loadAllMakes() {
    this.makeService.getAll(this.page).subscribe(
      res => {
        this.makes = res.content
      }
    )
  }

  loadModels() {
    this.modelService.getAll(this.make.id).subscribe(
      res => {
        console.log(this.models)
      }
    )
  }

  loadAllVehicleTypes() {
    this.vehicleTypeService.getAll().subscribe(
      res => {
        this.vehicleTypes = res;
      }
    )
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  /**
   * Send message to other component
   */
  send() {
    this.data.changeMessage(this.val)
  }

}
