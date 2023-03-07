import {User} from '../user/user';
import {Payment} from './payment';
import {OrderDetail} from './order-detail';


export interface OrderClothes {
  id?: number;
  user?: User;
  payment?: Payment;
  orderDetail?: OrderDetail;
  deleteStatus?: number;

}
