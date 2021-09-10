import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { FuelType } from 'src/app/model/fuelType.model';
import { Location } from 'src/app/model/location.model';
import { Make } from 'src/app/model/make.model';
import { ModelRes } from 'src/app/model/modelRes.model';
import { OfferReq } from 'src/app/model/offerReq.model';
import { OfferRes } from 'src/app/model/offerRes.model';
import { Vehicle } from 'src/app/model/vehicle.model';
import { VehicleReq } from 'src/app/model/VehicleReq.model';
import { VehicleRes } from 'src/app/model/vehicleRes.model';
import { VehicleType } from 'src/app/model/vehicleType.model';
import { FuelTypeService } from 'src/app/services/fuel-type.service';
import { LocationService } from 'src/app/services/location.service';
import { MakeService } from 'src/app/services/make.service';
import { ModelService } from 'src/app/services/model.service';
import { OfferService } from 'src/app/services/offer.service';
import { VehicleTypeService } from 'src/app/services/vehicle-type.service';
import { VehicleService } from 'src/app/services/vehicle.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  regs: string[] = [
    '1990', '1991', '1992', '1993', '1994', '1995', '1996', '1997', '1998', '1999', '2000',
    '2001', '2002', '2003', '2004', '2005', '2006', '2007', '2008', '2009', '2010', '2011',
    '2012', '2013', '2014', '2015', '2016', '2017', '2018', '2019', '2020', '2021', '2022'
  ].reverse();

  firstReg: string = "1989";

  makes: Make[] = [];
  make: Make = undefined;

  models: ModelRes[] = [];
  model: ModelRes = undefined;

  price: number;

  cc: number;

  hp: number;

  km: number;

  numberOfDors: number;

  vehicleTypes: VehicleType[] = [];
  vehicleType: VehicleType = undefined;

  fuelTypes: FuelType[] = [];
  fuelType: FuelType = undefined;

  locations: Location[] = [];
  location: Location = new Location();

  vehicles: VehicleRes[] = [];
  vehicle: VehicleReq = new VehicleReq();

  description: string = "";

  url: string;

  offerId;

  offerRes: OfferRes;
  offerReq: OfferReq;

  locationId = 0;

  constructor(
    private makeService: MakeService,
    private modelService: ModelService,
    private vehicleTypeService: VehicleTypeService,
    private fuelTypeService: FuelTypeService,
    private locationService: LocationService,
    private vehicleService: VehicleService,
    private offerService: OfferService,
    private snackBar: MatSnackBar,
    private route: ActivatedRoute,
    public datepipe: DatePipe,
    ) { }

  async ngOnInit() {
    this.offerId = this.route.snapshot.paramMap.get('offerId');
    console.log("------")
    console.log(this.offerId)
   
    await this.loadOffer();
  }

  async loadOffer() {
    this.offerRes = await this.offerService.getOne(this.offerId).toPromise();
    var res = this.offerRes;

    this.price = res.price;
    this.locationId = res.locationId;
    this.description = res.description;
    this.location = await this.locationService.getOne(res.locationId);
    this.locations = await this.locationService.getAll();
  }

  async edit() {
    if (!this.validate()) {
      this.openSnackBar('You must fill all fields.');
      return;
    };
    
    var date = this.datepipe.transform(this.offerRes.date, 'yyyy-MM-dd') + 'T23:00:00.000+00:00'
    var res = this.offerRes;

    this.offerReq = new OfferReq({date: date, description: this.description, price: this.price, locationId: this.locationId, vehicleId: res.vehicleId})

    console.log(this.offerReq);
    // Update offer
    await this.offerService.put(this.offerReq, this.offerId, this.url).toPromise().then(
      () => {
        this.openSnackBar('You successfuly updated your offer.');
      }, err => {
        if (err.status == 504) this.openSnackBar('You are offline! Go online and then update offer.');
        else this.openSnackBar('There is problem updateing your offer.');
      }
    );
  }

  validate(): boolean {
    if (this.price == undefined) return false;
    if (this.price < 0) return false;
    if (this.location.city == undefined) return false;
    // if (this.url == undefined) return false;
    
    return true;
  }

  /**
   * Take url of choosen image.
   *
   * @param event event file selected
   */
   onSelectFile(event): void {
    if (event.target.files && event.target.files[0]) {
      this.url = event.target.files[0];
    }
  }

  openSnackBar(message: string): void {
    this.snackBar.open(message, 'Dismiss', {
      duration: 4000,
    });
  }

}

/*
"http://localhost:8080/api/locations/**",
        "http://localhost:8080/api/files/**",
        "http://localhost:8080/api/vehicles/**",
        "http://localhost:8080/api/models/**",
        "http://localhost:8080/api/makes/**",
        "http://localhost:8080/api/fuel-types/**",
        "http://localhost:8080/api/vehicle-types/**",
        "http://localhost:8080/api/authenticated-users/**",
        "http://localhost:8080/api/makes/by-page?page=0&size=1000",
        "http://localhost:8080/api/models/by-make/**"



        "https://fonts.gstatic.com/s/roboto/v27/KFOlCnqEu92Fr1MmEU9fBBc4AMP6lQ.woff2",
          "https://fonts.gstatic.com/s/materialicons/v99/flUhRq6tzZclQEJ-Vdg-IuiaDsNcIhQ8tQ.woff2",
          "https://fonts.gstatic.com/s/roboto/v27/KFOmCnqEu92Fr1Mu4mxKKTU1Kg.woff2"
*/