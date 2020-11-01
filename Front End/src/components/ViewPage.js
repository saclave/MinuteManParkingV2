import React, { Component } from 'react';
import qrCode from '../images/qrcode.png';
import { Card} from 'antd';
import { EditOutlined, SettingOutlined } from '@ant-design/icons';

class ViewPage extends Component {
    constructor(props) {
        super(props);
        this.state={
            name:'Red',
            age: '22',
            email: 'adanzra@oocl.com',
            birthday: '5/21/1998'

        }    
    }
    render() {
        const { Meta } = Card;
        return (
            <div>
                <Card
                      className="viewCard"
                      style={{ width: 250 }}
                      cover={
                        <img
                          alt="example"
                          src={qrCode}
                          style={{ border: '2px solid #407294'}}
                        />
                      }
                      actions={[
                        <SettingOutlined key="setting" style={{color: "blue"}}/>,
                        <EditOutlined key="edit" style={{color: "blue"}}/>,
                      ]}
                >   
                <Meta title={this.state.name} 
                    description={this.state.age + " yrs old"} />
                <Meta description={this.state.email}/>
                <Meta description={this.state.birthday} />
                    </Card>
          </div>
        );
    }
}

export default ViewPage;