import React, { Component } from "react";
import { Table } from "reactstrap";
import "./footer.css";
import { Link } from 'react-router-dom';

export default function Footer() {
    return (
        <>
            <div className="footer">
                <div className="totalCount">1잔</div>
                <div className="totalPrice">3500 원</div>
            </div>
        </>
    )
}
