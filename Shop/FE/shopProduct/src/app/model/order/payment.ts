import {OrderClothes} from './order-clothes';


export interface Payment {
  id?: number;
  paymentStatus?: number;
  orderClothes?: OrderClothes;
  shippingDescription?: string;
  deleteStatus?: number;
}
