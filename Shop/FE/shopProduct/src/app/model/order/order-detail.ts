import {Clothes} from '../product/clothes';
import {OrderClothes} from './order-clothes';

export interface OrderDetail {
  id?: number;
  quantity?: number;
  clothes?: Clothes;
  orderClothes?: OrderClothes;
}
