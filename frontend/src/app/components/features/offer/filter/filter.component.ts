import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Filter } from 'src/app/model/filter.model';
import { FuelType } from 'src/app/model/fuelType.model';
import { Make } from 'src/app/model/make.model';
import { ModelRes } from 'src/app/model/modelRes.model';
import { VehicleType } from 'src/app/model/vehicleType.model';
import { DataService } from 'src/app/services/data.service';
import { FuelTypeService } from 'src/app/services/fuel-type.service';
import { MakeService } from 'src/app/services/make.service';
import { ModelService } from 'src/app/services/model.service';
import { VehicleTypeService } from 'src/app/services/vehicle-type.service';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent implements OnInit {

  subscription: Subscription;

  page: number = 0;

  regs: string[] = [
    '2000', '2001', '2002', '2003', '2004', '2005', '2006', '2007', '2008', '2009', '2010', '2011',
    '2012', '2013', '2014', '2015', '2016', '2017', '2018', '2019', '2020', '2021', '2022'
  ]

  firstRegFrom: string = "1886";
  firstRegTo: string = String(Number(this.regs[this.regs.length - 1]) + 1);

  makes: Make[] = [];
  make: Make = new Make();

  models: ModelRes[] = [];
  model: ModelRes = new ModelRes();

  priceFrom: number;
  priceTo: number;

  ccFrom: number;
  ccTo: number;

  hpFrom: number;
  hpTo: number;

  kmFrom: number;
  kmTo: number;

  vehicleTypes: VehicleType[] = [];
  vehicleType: VehicleType = new VehicleType();

  fuelTypes: FuelType[] = [];
  fuelType: FuelType = new FuelType();

  filter: Filter = new Filter();

  constructor(
    private data: DataService,
    private makeService: MakeService,
    private modelService: ModelService,
    private vehicleTypeService: VehicleTypeService,
    private fuelTypeService: FuelTypeService,


  ) { }

  ngOnInit(): void {
    // this.subscription = this.data.currentMessage.subscribe(message => this.filter = message)

    this.loadAllMakes();
    this.loadAllVehicleTypes();
    this.loadAllFuelTypes();
  }

  loadAllMakes() {
    this.makeService.getAll(0, 300).subscribe(
      res => {
        this.makes = res.content
      }
    )
  }

  loadModels() {
    this.modelService.getAll(this.make.id).subscribe(
      res => {
        this.models = res
      }
    )
  }

  clearModels() {
    this.models = [];
  }

  loadAllVehicleTypes() {
    this.vehicleTypeService.getAll().subscribe(
      res => {
        this.vehicleTypes = res;
      }
    )
  }

  loadAllFuelTypes() {
    this.fuelTypeService.getAll().subscribe(
      res => {
        this.fuelTypes = res;
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
    this.createFilter();

    // this.data.sendFilter(this.filter);
  }

  createFilter() {
    if (this.priceFrom == undefined) this.filter.priceFrom = 0;
    else this.filter.priceFrom = this.priceFrom;

    if (this.priceTo == undefined) this.filter.priceTo = 999999999;
    else this.filter.priceTo = this.priceTo;

    if (this.kmFrom == undefined) this.filter.kmFrom = -1;
    else this.filter.kmFrom = this.kmFrom;

    if (this.kmTo == undefined) this.filter.kmTo = 9999999;
    else this.filter.kmTo = this.kmTo;

    if (this.ccFrom == undefined) this.filter.ccFrom = -1;
    else this.filter.ccFrom = this.ccFrom;

    if (this.ccTo == undefined) this.filter.ccTo = 99999;
    else this.filter.ccTo = this.ccTo;

    if (this.hpFrom == undefined) this.filter.hpFrom = -1;
    else this.filter.hpFrom = this.hpFrom;

    if (this.hpTo == undefined) this.filter.hpTo = 99999;
    else this.filter.hpTo = this.hpTo;

    if (this.vehicleType == undefined) this.filter.vehicleTypeId = 0;
    else this.filter.vehicleTypeId = this.vehicleType.id;

    if (this.fuelType == undefined) this.filter.fuelTypeId = 0;
    else this.filter.fuelTypeId = this.fuelType.id;

    if (this.make == undefined) {
      this.filter.makeId = 0;
      // this.model = new Model({ id: 0, name: 'None', makeId: 0 });
      this.model = new ModelRes();
    } 
    else this.filter.makeId = this.make.id;

    if (this.model == undefined) this.filter.modelId = 0;
    else this.filter.modelId = this.model.id;

    this.filter.firstRegFrom = this.firstRegFrom;
    this.filter.firstRegTo = this.firstRegTo;
  }

}
