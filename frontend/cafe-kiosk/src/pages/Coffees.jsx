import React from "react";
import Coffee from "../component/coffee/Coffee"
import Footer from "../component/Footer";

export default function Coffees() {
    return (
        <div className="coffees">
            <Coffee/>
            <Coffee/>
            <Coffee/>
            <Coffee/>

            <Footer/>
        </div>
    )
}