import React, { Component } from 'react';

import { Image } from 'antd';
import { Typography } from 'antd';

import parking from '../images/parking.jpg';

const { Title } = Typography;

class HomePageAbout extends Component {
    render() {
        return (
            <div className="home-page-content">
                <Title>About Us</Title>
                <Image width={1000} src={parking} />
            </div>
        );
    }
}

export default HomePageAbout;