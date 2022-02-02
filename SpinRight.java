

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@Autonomous(name="Spin Right (Red)", group="Iterative Opmode")
// bhat
public class NewAutoMode extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    public DcMotor leftDrive = null;
    public DcMotor back_left_drive = null;
    public DcMotor rightDrive = null;
    public DcMotor back_right_drive = null;
    public DcMotor arm = null;
    
    public Servo grip = null;
    public DcMotor spin = null;

    /*
     * Code to run ONCE when the driver hits INIT
     */
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
        arm = hardwareMap.get(DcMotor.class, "arm");
        grip = hardwareMap.get(Servo.class, "grip");
        spin = hardwareMap.get(DcMotor.class, "spin");



        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        back_left_drive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        back_right_drive.setDirection(DcMotor.Direction.REVERSE);
        spin.setDirection(DcMotor.Direction.REVERSE);
        

        grip.setPosition(0);


        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
        

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
        runtime.reset();
        
                grip.setPosition(1);


        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        back_left_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        back_right_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        spin.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        

        grip.setPosition(0);
        
       forward();
       

    }


    public void turn(){
        leftDrive.setTargetPosition(-800);
        back_left_drive.setTargetPosition(-800);
        rightDrive.setTargetPosition(-500);
        back_right_drive.setTargetPosition(-500);

        
        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        back_left_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        back_right_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        
        leftDrive.setPower(1);
        back_left_drive.setPower(1);
        rightDrive.setPower(-0.5);
        back_right_drive.setPower(-0.5);

        
        
    }
    
    public void forwardbutnotreally(){
        leftDrive.setTargetPosition(-2750);
        back_left_drive.setTargetPosition(-2750);
        rightDrive.setTargetPosition(-3650);
        back_right_drive.setTargetPosition(-3650);
        spin.setTargetPosition(-1000000);

        
        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        back_left_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        back_right_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        spin.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        
        leftDrive.setPower(-0.2);
        back_left_drive.setPower(-0.2);
        rightDrive.setPower(-0.1);
        back_right_drive.setPower(-0.1);
        spin.setPower(0.2);

    }
    
    public void forward(){
        grip.setPosition(0);
        
        leftDrive.setTargetPosition(-2860);
        back_left_drive.setTargetPosition(-2860);
        rightDrive.setTargetPosition(-2600);
        back_right_drive.setTargetPosition(-2600);
        spin.setTargetPosition(1000000);

        
        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        back_left_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        back_right_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        spin.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        

        
        leftDrive.setPower(-0.4);
        back_left_drive.setPower(-0.4);
        rightDrive.setPower(-0.4);
        back_right_drive.setPower(-0.4);
        spin.setPower(-1);

    }
    
    public void spinnythang(){
        
     
        spin.setTargetPosition(1000000);
        
      
        spin.setMode(DcMotor.RunMode.RUN_TO_POSITION);
 
        spin.setPower(1000000090);
    }
    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
       
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}
