package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="9328: Linear Single Driver", group="9328")
public class SingleDriverLinear extends LinearOpMode {
    HardwareMap9328 hwMap = new HardwareMap9328();
    double leftStick, rightStick;
    boolean clawState = false;
    @Override
    public void runOpMode() {

        hwMap.init(hardwareMap);
        waitForStart();

        hwMap.claw.setTargetPosition(45);
        while (opModeIsActive()) {

            leftStick   = gamepad1.left_stick_y;
            rightStick  = gamepad1.right_stick_y;

            hwMap.leftTread.setPower(leftStick);
            hwMap.rightTread.setPower(rightStick);

            if (gamepad1.dpad_up) {
                hwMap.clawWinch.setPower(0.75);
            } else if (gamepad1.dpad_down) {
                hwMap.clawWinch.setPower(-0.75);
            } else if (gamepad1.a & clawState) {
                hwMap.claw.setTargetPosition(45);
                clawState = false;
            } else if (gamepad1.a & !clawState) {
                hwMap.claw.setTargetPosition(0);
                clawState = true;
            } else {
                hwMap.clawWinch.setPower(0);
            }
        }
    }
}
