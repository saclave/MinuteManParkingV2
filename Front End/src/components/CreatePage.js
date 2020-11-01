import React, { Component } from 'react';
import { Form, Input, Button,DatePicker, Select } from 'antd';
     
class createPage extends Component {
    render() {
        const layout = {
            labelCol: { span: 8 },
            wrapperCol: { span: 9 },
          };
          const config = {
            rules: [{ type: 'object', required: true, message: 'Please select birthday!' }],
          };
          const validateMessages = {
            required: '${label} is required!',
            types: {
              email: '${label} is not validate email!',
            },
          };
            const onFinish = values => {
              console.log(values);
              this.props.addUser(values);
            };
            const { Option } = Select;  
              
        return (
            <div>
                <Form {...layout} name="nest-messages" onFinish={onFinish} validateMessages={validateMessages}>
                  <Form.Item name={['user', 'firstName']} label="First Name" rules={[{ required: true }]} >
                    <Input />
                  </Form.Item>
                  <Form.Item name={['user', 'lastName']} label="Last Name" rules={[{ required: true }]}>
                    <Input />
                  </Form.Item>
                  <Form.Item name={['user', 'username']} label="username" rules={[{ required: true }]}>
                    <Input />
                  </Form.Item>
                  <Form.Item name={['user', 'password']} label="password" rules={[{ required: true }]}>
                    <Input.Password />
                  </Form.Item>
                  <Form.Item name={['user', 'email']} label="Email" rules={[{ type: 'email' }]}>
                    <Input />
                  </Form.Item>
                  <Form.Item name={['user', 'gender']} label="Gender" rules={[{ required: true }]}>
                   <Select
                     placeholder="Select a option and change input text above"
                     allowClear
                   >
                     <Option value="male">male</Option>
                     <Option value="female">female</Option>
                     <Option value="other">other</Option>
                   </Select>
                 </Form.Item>
                  <Form.Item name={['user', 'date-picker']} label="Birthdate" {...config}>
                    <DatePicker />
                  </Form.Item>
                  <Form.Item wrapperCol={{ ...layout.wrapperCol, offset: 8 }}>
                    <Button type="primary" htmlType="submit">
                      Submit
                    </Button>
                  </Form.Item>
                </Form>
            </div>
        );
    }
}

export default createPage;