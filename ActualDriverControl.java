/*
Copyright 2021 FIRST Tech Challenge Team FTC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute,
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.text.SimpleDateFormat;
import java.util.Date;


@TeleOp

public class ActualDriverControl extends OpMode {
    /* Declare OpMode members. */
    public DcMotor leftDrive = null;
    public DcMotor back_left_drive = null;
    public DcMotor rightDrive = null;
    public DcMotor back_right_drive = null;
    public DcMotor arm = null;
    public DcMotor spin = null;
    
    public Servo grip = null;

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        back_left_drive = hardwareMap.get(DcMotor.class, "back_left_drive");
        back_right_drive = hardwareMap.get(DcMotor.class, "back_right_drive");
        spin = hardwareMap.get(DcMotor.class, "spin" );
        arm = hardwareMap.get(DcMotor.class, "arm");
        grip = hardwareMap.get(Servo.class, "grip");

        grip.setPosition(0);

        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        back_left_drive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        back_right_drive.setDirection(DcMotor.Direction.REVERSE);
        spin.setDirection(DcMotor.Direction.REVERSE);



    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        grip.setPosition(0);
        
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
        public void loop() {
        if (gamepad1.dpad_down){
            leftDrive.setPower(100);
            back_left_drive.setPower(100);
            rightDrive.setPower(100);
            back_right_drive.setPower(100);
        }else{
            leftDrive.setPower(0);
            back_left_drive.setPower(0);
            rightDrive.setPower(0);
            back_right_drive.setPower(0);
        }
        
        
             if (gamepad1.dpad_up){
            leftDrive.setPower(-100);
            back_left_drive.setPower(-100);
            rightDrive.setPower(-100);
            back_right_drive.setPower(-100);
        }else{
            leftDrive.setPower(0);
            back_left_drive.setPower(0);
            rightDrive.setPower(0);
            back_right_drive.setPower(0);
        }
        
        
             if (gamepad1.dpad_left){
            leftDrive.setPower(100);
            back_left_drive.setPower(100);
            rightDrive.setPower(-100);
            back_right_drive.setPower(-100);
        }else{
            leftDrive.setPower(0);
            back_left_drive.setPower(0);
            rightDrive.setPower(0);
            back_right_drive.setPower(0);
        }
        
             if (gamepad1.dpad_right){
            leftDrive.setPower(-100);
            back_left_drive.setPower(-100);
            rightDrive.setPower(100);
            back_right_drive.setPower(100);
        }else{
            leftDrive.setPower(0);
            back_left_drive.setPower(0);
            rightDrive.setPower(0);
            back_right_drive.setPower(0);
        }
        
        
        if (gamepad2.dpad_up){
         arm.setPower(10);
            
        }else {
            arm.setPower(0);
            
        }
        if (gamepad2.dpad_down){
            arm.setPower(-0.7);
            
        }else {
            arm.setPower(0);
            
        }
        
        if (gamepad2.a){
            grip.setPosition(1);
            
        }
        if (gamepad2.b){
            grip.setPosition(0);
            
        }
          if (gamepad2.x){
            grip.setPosition(1);
            
        }
        if (gamepad2.y){
            grip.setPosition(0);
            
        }
        
        //1
        if (gamepad1.left_bumper){
            spin.setPower(0.5);
            
        }else {
            spin.setPower(0);
            
        }
        if (gamepad1.right_bumper){
            spin.setPower(-0.5);
            
        }else {
            spin.setPower(0);
            
        }
    
    
    //2
        if (gamepad2.left_bumper){
            spin.setPower(0.5);
            
        }else {
            spin.setPower(0);
            
        }
        if (gamepad2.right_bumper){
            spin.setPower(-0.5);
            
        }else {
            spin.setPower(0);
            
        }
         
    }


    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {

    }
}
