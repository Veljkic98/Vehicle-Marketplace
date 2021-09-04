import { Component, Input, OnInit } from '@angular/core';
import { Location } from 'src/app/model/location.model';
import { Offer } from 'src/app/model/offer.model';
import { OfferRes } from 'src/app/model/offerRes.model';
import { VehicleRes } from 'src/app/model/vehicleRes.model';
import { AuthUserService } from 'src/app/services/auth-user.service';
import { FuelTypeService } from 'src/app/services/fuel-type.service';
import { LocationService } from 'src/app/services/location.service';
import { MakeService } from 'src/app/services/make.service';
import { ModelService } from 'src/app/services/model.service';
import { VehicleTypeService } from 'src/app/services/vehicle-type.service';
import { VehicleService } from 'src/app/services/vehicle.service';

@Component({
  selector: 'app-offer',
  templateUrl: './offer.component.html',
  styleUrls: ['./offer.component.css']
})
export class OfferComponent implements OnInit {

  @Input()
  offerRes: OfferRes;

  offer: Offer = new Offer();

  constructor(
    private locationService: LocationService,
    private vehicleService: VehicleService,
    private modelService: ModelService,
    private fuelTypeService: FuelTypeService,
    private vehicleTypeService: VehicleTypeService,
    private makeService: MakeService,
    private authUserService: AuthUserService,
  ) { }

  ngOnInit(): void {
    this.loadOffer();
  }

  async loadOffer() {
    this.offer.date = this.offerRes.date;
    this.offer.description = this.offerRes.description;
    this.offer.id = this.offerRes.id;
    this.offer.imageUri = this.offerRes.imageUri;
    this.offer.price = this.offerRes.price;

    this.offer.location = await this.locationService.getOne(this.offerRes.locationId);

    var vehicleRes = await this.vehicleService.getOne(this.offerRes.vehicleId);
    this.offer.vehicle.cubicCapacity = vehicleRes.cubicCapacity;
    this.offer.vehicle.firstRegistration = vehicleRes.firstRegistration;
    this.offer.vehicle.id = vehicleRes.id;
    this.offer.vehicle.kilometer = vehicleRes.kilometer;
    this.offer.vehicle.numberOfDoors = vehicleRes.numberOfDoors;
    this.offer.vehicle.power = vehicleRes.power;

    var modelRes = await this.modelService.getOne(vehicleRes.modelId);
    this.offer.vehicle.model.id = modelRes.id;
    this.offer.vehicle.model.name = modelRes.name;
    this.offer.vehicle.model.make = await this.makeService.getOne(modelRes.makeId);

    this.offer.vehicle.fuelType = await this.fuelTypeService.getOne(vehicleRes.fuelTypeId);
    this.offer.vehicle.vehicleType = await this.vehicleTypeService.getOne(vehicleRes.vehicleTypeId);
    this.offer.authenticatedUser = await this.authUserService.getOne(this.offerRes.authenticatedUserId);
  }

}
