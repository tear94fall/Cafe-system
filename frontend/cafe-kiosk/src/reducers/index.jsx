import { configureStore, combineReducers } from '@reduxjs/toolkit';
import cartReducer from './cartReducer/cartReducer';

const rootReducer = combineReducers({
    cart: cartReducer,
});

export const store = configureStore({
    reducer: cartReducer,
});